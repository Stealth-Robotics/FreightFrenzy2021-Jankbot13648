package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class TurretToPosition extends CommandBase {
    private final Manipulator manipulator;

    private final int target;
    private final double speed;

    public TurretToPosition(Manipulator manipulator, int target, double speed) {
        this.manipulator = manipulator;
        this.target = target;
        this.speed = speed;

        addRequirements(manipulator);
    }

    @Override
    public void initialize()
    {
        manipulator.setTurretTargetPosition(target, speed);
    }

    @Override
    public void execute()
    {
        double update = manipulator.update();

        /*FtcDashboard.getInstance().getTelemetry().addData("Manipulator Target", manipulator.getTarget());
        FtcDashboard.getInstance().getTelemetry().addData("Current Manipulator Position", manipulator.getPosition());
        FtcDashboard.getInstance().getTelemetry().addData("Update (Speed To Get To Target)", update);
        FtcDashboard.getInstance().getTelemetry().addData("Last Error", manipulator.getLastError());
        FtcDashboard.getInstance().getTelemetry().addData("Offset", manipulator.getEncoderOffset());*/

        FtcDashboard.getInstance().getTelemetry().update();

        manipulator.setSpeed(update);

        manipulator.setSpeed(manipulator.update());
    }

    @Override
    public void end(boolean isInterrupted)
    {
        manipulator.setSpeed(0);
    }

    @Override
    public boolean isFinished()
    {
        return manipulator.atTargetPosition();
    }
}