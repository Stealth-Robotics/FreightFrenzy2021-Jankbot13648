package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoReverseLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoReverseMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

public class RedTopAutoCommand extends SequentialCommandGroup {
    public RedTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {
        addCommands(
                new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(0)))),
                new FollowTrajectory(drive, Red_Top_Path.RT_traj1).alongWith(new RedHighPreset(elevator, manipulator)),
                new DropGamePiece(elevator, manipulator),

                // Cycle #1
                new InstantCommand(() -> intake.setIntake(1)),
                new FollowTrajectory(drive, Red_Top_Path.RT_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                // new FollowTrajectory(drive, Red_Top_Path.RT_traj3),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                //new ReLocalizeDriveBase(drive, true),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(-0.66)),

                new FollowTrajectory(drive, Red_Top_Path.RT_traj3).alongWith(new RedHighPreset(elevator, manipulator)),
                new DropGamePiece(elevator, manipulator)
        /*
                        // Cycle #2
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj4).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj5).alongWith(new RedHighPreset(elevator, manipulator)),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #3
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj6).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj7)/*,
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj14),
                        new RedHighPreset(elevator, manipulator),
                        new DropGamePiece(elevator, manipulator),*/
        );
    }
}
