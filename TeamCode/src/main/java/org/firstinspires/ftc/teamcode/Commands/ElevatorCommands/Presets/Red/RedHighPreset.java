package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedHighPreset extends SuperStructureToPosition {
    public RedHighPreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                1400 + 400,
                1,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}
