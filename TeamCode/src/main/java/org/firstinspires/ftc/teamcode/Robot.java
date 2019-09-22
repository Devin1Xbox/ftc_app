package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Robot extends LinearOpMode  {

    private DcMotor motor;

    // this is the constructor
    // you instantiate motors and hardware here
    // hardware.getMotor or whatever



    DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;

    Robot() {
//        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
//        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
//        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
//        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
    }

        @Override
        public void runOpMode () throws InterruptedException {
            // do nothing, we'll inherit from this class and implement the function there
        }
//
//        float inputy = gamepad1.left_stick_y;
//        float inputx = gamepad1.left_stick_x;
//        float inputrt = gamepad1.right_trigger;
//        float inputlt = gamepad1.left_trigger;
//
//        void goForward() {
//            // func of making robot go forwards
//            frontLeftMotor.setPower(Range.clip(inputy,-1.0,1.0));
//            backLeftMotor.setPower(Range.clip(inputy,-1.0,1.0));
//            frontRightMotor.setPower(Range.clip(inputy,-1.0,1.0));
//            backRightMotor.setPower(Range.clip(inputy,-1.0,1.0));
//        }
//
//        void goBackward() {
//            // func of making robot go backwards
//            frontLeftMotor.setPower(Range.clip(-inputy,-1.0,1.0));
//            backLeftMotor.setPower(Range.clip(-inputy,-1.0,1.0));
//            frontRightMotor.setPower(Range.clip(-inputy,-1.0,1.0));
//            backRightMotor.setPower(Range.clip(-inputy,-1.0,1.0));
//        }
//
//        void turnLeft() {
//            // func of making robot go left
//            frontRightMotor.setPower(Range.clip(inputx,-1.0,1.0));
//            backRightMotor.setPower(Range.clip(inputx,-1.0,1.0));
//            frontLeftMotor.setPower(Range.clip(-inputx,-1.0,1.0));
//            backLeftMotor.setPower(Range.clip(-inputx,-1.0,1.0));
//        }
//
//        void turnRight() {
//            // func of making robot go right
//            frontLeftMotor.setPower(Range.clip(inputx,-1.0,1.0));
//            backLeftMotor.setPower(Range.clip(inputx,-1.0,1.0));
//            frontRightMotor.setPower(Range.clip(-inputx,-1.0,1.0));
//            backRightMotor.setPower(Range.clip(-inputx,-1.0,1.0));
//        }
//
//        public void strafeRight() {
//            // func of making robot strafe left **still questionable
//            frontLeftMotor.setPower(Range.clip(inputrt,-1.0,1.0));
//            backLeftMotor.setPower(Range.clip(inputrt,-1.0,1.0));
//            frontRightMotor.setPower(Range.clip(inputrt,-1.0,1.0));
//            backRightMotor.setPower(Range.clip(inputrt,-1.0,1.0));
//
//        }

        void strafeLeft(double power, int targetPosition) {
        //func of making robot strafe right **still questionable*********
            motor.setTargetPosition(targetPosition);
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(-power);
        }

}
