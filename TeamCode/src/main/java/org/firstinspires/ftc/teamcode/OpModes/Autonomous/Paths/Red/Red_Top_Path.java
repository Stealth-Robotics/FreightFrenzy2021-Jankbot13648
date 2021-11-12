package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.TRACK_WIDTH;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;

import java.util.Arrays;

public class Red_Top_Path {

    //clear bumps
    public static Trajectory RT_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(180)))
            .lineTo(new Vector2d(-7, 0.25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //approach goal
    public static Trajectory RT_traj2 = BuildTrajectory(RT_traj1.end())
            .lineTo(new Vector2d(-20, 26),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to warehouse
    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj2.end())
            .lineTo(new Vector2d(-7, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //drive into freight
    public static Trajectory RT_traj4 = BuildTrajectory(RT_traj3.end())
            .lineTo(new Vector2d(24, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //back out
    public static Trajectory RT_traj5 = BuildTrajectory(RT_traj4.end())
            .lineTo(new Vector2d(-7, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to goal
    public static Trajectory RT_traj6 = BuildTrajectory(RT_traj5.end())
            .lineTo(new Vector2d(-20, 26),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to warehouse
    public static Trajectory RT_traj7 = BuildTrajectory(RT_traj6.end())
            .lineTo(new Vector2d(-7, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //drive into freight
    public static Trajectory RT_traj8 = BuildTrajectory(RT_traj7.end())
            .lineTo(new Vector2d(26, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //back out
    public static Trajectory RT_traj9 = BuildTrajectory(RT_traj8.end())
            .lineTo(new Vector2d(-7, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to goal
    public static Trajectory RT_traj10 = BuildTrajectory(RT_traj9.end())
            .lineTo(new Vector2d(-20, 26),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to warehouse
    public static Trajectory RT_traj11 = BuildTrajectory(RT_traj10.end())
            .lineTo(new Vector2d(-7, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //drive into freight
    public static Trajectory RT_traj12 = BuildTrajectory(RT_traj11.end())
            .lineTo(new Vector2d(28, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //exit freight pile but remain parked
    public static Trajectory RT_traj13 = BuildTrajectory(RT_traj12.end())
            .lineTo(new Vector2d(20, .25),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to goal
    public static Trajectory RT_traj14 = BuildTrajectory(RT_traj13.end())
            .lineTo(new Vector2d(-20, 26),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(MAX_ANG_VEL),
                new MecanumVelocityConstraint(MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(MAX_ACCEL));
    }
}
