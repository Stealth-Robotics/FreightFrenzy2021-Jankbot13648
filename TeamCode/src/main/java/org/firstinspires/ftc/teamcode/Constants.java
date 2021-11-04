package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Constants {
    public static final class AutomationStuff {
        //automation stuff -
        public static final String DISTANCE_SENSOR_NAME = "ds";
        public static final String LIMIT_SWITCH_NAME = "ls";
    }

    public static final class DriveBase {
        public static final String FRONT_LEFT_DRIVE_MOTOR_NAME = "fl";
        public static final String FRONT_RIGHT_DRIVE_MOTOR_NAME = "fr";
        public static final String REAR_LEFT_DRIVE_MOTOR_NAME = "rl";
        public static final String REAR_RIGHT_DRIVE_MOTOR_NAME = "rr";
    }

    public static final class Intake {
        public static final String INTAKE_MOTOR_NAME = "im";
        //public static final String INTAKE_DEPLOYER_SERVO_NAME = "id";
    }

    public static final class Elevator {
        public static final String ELEVATOR_MOTOR_NAME = "em";

        // Minimum position of elevator to stop movement
        // TODO: Check Value
        public static final int MINIMUM_POSITION = 0;

        // Maximum position of elevator
        public static final int MAXIMUM_POSITION = 2350;

        // Position in which turret clears the bottom if extender is retracted //min safe pos
        public static final int SAFE_TURRET_POSITION = 450;

        // Position in which everything clears duck spinner if extender is extended
        public static final int SAFE_EXTENDER_POSITION = 1090;
    }

    public static final class Manipulator {
        public static final class Turret {
            public static final String TURRET_SERVO_NAME ="ts";

            // Storage angle to not hit capstone
            public static final double RIGHT_MAXIMUM_POSITION = 0.11;

            // Stores angle to not hit duck spinner
            public static final double LEFT_MAXIMUM_POSITION = 0.9;

            public static final double ZERO_POSITION = 0.495;


        }

        public static final class Extender {
            public static final String EXTENDER_SERVO_NAME ="es";

            // Maximum rotation of extender
            public static double MAX_POS = 0.31  ;

            // Minimum rotation of extender
            public static double MIN_POS = 0.685;

            // Stores position of capstone
            public static final double CAPSTONE_POSITION = 0;
        }

        public static final class Claw {
            public static final String CLAW_SERVO_NAME ="cs";
            public static final String DISTANCE_SENSOR_NAME = "sdc";

            public static double OPEN_POSITION = 0.47;
            public static double CLOSE_POSITION = 0.35;
            public static final double CAPSTONE_OPEN_FULLY = 0.7;
        }
    }

    public static final class DuckSpinner {
        public static final String DUCK_SPINNER_MOTOR_NAME = "qs";
    }

    public static final class Vision {
        public static final String CAPSTONE_DETECTION_CAMERA_NAME_LEFT = "Webcam 1";
        public static final String CAPSTONE_DETECTION_CAMERA_NAME_RIGHT = "Webcam 2";

        public static final int CAMERA_RESOLUTION_WIDTH = 1280;
        public static final int CAMERA_RESOLUTION_HEIGHT = 720;
    }
}