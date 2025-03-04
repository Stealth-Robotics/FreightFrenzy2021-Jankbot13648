package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Blue;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue.BlueBottomAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands.CapstoneGrabberDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretResetWithPot;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

@Autonomous(name = "BLUE | Bottom Auto", group = "Blue", preselectTeleOp = "BLUE | Tele-Op")
public class Blue_Bottom_Auto extends LinearOpMode {
    Drive drive;
    Elevator elevator;
    Manipulator manipulator;
    Intake intake;
    DuckSpinner duckSpinner;
    CapstoneGrabber capstoneGrabber;
    CapstoneDetectionCamera capstoneDetectionCamera;

    CapstonePipeline.CapstonePosition capstonePosition;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(new MecanumDrive(hardwareMap), true);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap);
        intake = new Intake(hardwareMap);
        duckSpinner = new DuckSpinner(hardwareMap);
        capstoneGrabber = new CapstoneGrabber(hardwareMap);
        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap, false);

        register(
                drive,
                elevator,
                manipulator,
                intake,
                duckSpinner,
                capstoneGrabber
        );

        HeadingStorage.STORED_HEADING = 0;
        drive.setHeadingOffset(0);

        manipulator.closeClaw();
        manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.15);
        duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP);

        capstoneGrabber.setDefaultCommand(new CapstoneGrabberDefault(capstoneGrabber));

        int loopcount = 0;

        while (!isStarted()) {
            capstonePosition = capstoneDetectionCamera.getPosition();

            telemetry.addData("Capstone Position", capstonePosition);
            telemetry.addData("Left Analysis", capstoneDetectionCamera.getAnalysis()[0]);
            telemetry.addData("Middle Analysis", capstoneDetectionCamera.getAnalysis()[1]);
            telemetry.addData("Right Analysis", capstoneDetectionCamera.getAnalysis()[2]);
            telemetry.update();

            if (manipulator.getPotValue() > Constants.Manipulator.Turret.POT_ZERO_VALUE && loopcount < 500) {
                manipulator.setSpeed((manipulator.getPotValue() - Constants.Manipulator.Turret.POT_ZERO_VALUE) + .05);
                loopcount++;
            }
            else  if (manipulator.getPotValue() < Constants.Manipulator.Turret.POT_ZERO_VALUE && loopcount < 500) {
                manipulator.setSpeed((manipulator.getPotValue() - Constants.Manipulator.Turret.POT_ZERO_VALUE) - .05);
                loopcount++;
            }
            else  manipulator.setSpeed(0);
            if (loopcount == 501) {
                manipulator.resetTurretEncoder();
            }



        }

        schedule(
                new BlueBottomAutoCommand(
                        drive,
                        elevator,
                        manipulator,
                        intake,
                        duckSpinner,
                        capstonePosition
                )
        );

        while (!isStopRequested() && opModeIsActive())
        {
            getCommandScheduler().run();
        }

        getCommandScheduler().reset();
    }

    public CommandScheduler getCommandScheduler()
    {
        return CommandScheduler.getInstance();
    }

    public void register(Subsystem... subsystems)
    {
        getCommandScheduler().registerSubsystem(subsystems);
    }

    public void schedule(Command... commands)
    {
        getCommandScheduler().schedule(commands);
    }
}
