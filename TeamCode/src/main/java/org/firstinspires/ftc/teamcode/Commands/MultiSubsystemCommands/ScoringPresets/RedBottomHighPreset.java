package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedBottomHighPreset extends SequentialCommandGroup { //for use in red bottom auto only

    public RedBottomHighPreset(Elevator elevator, Manipulator manipulator) {

            addCommands(
                    new ParallelCommandGroup(
                            new InstantCommand(() -> manipulator.setArm(0.43)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION + 175, 1),
                            new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS))
                    ),
                    new ElevatorToPosition(elevator, 1025, 1)
            );

        addRequirements(elevator, manipulator);
    }
}
