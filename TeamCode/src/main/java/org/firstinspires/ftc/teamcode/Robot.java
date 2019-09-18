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
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
    }

        @Override
        public void runOpMode () throws InterruptedException {
            // do nothing, we'll inherit from this class and implement the function there
        }

        void goForward (double power){
            // func of making robot go forwards
            frontLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            backLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            frontRightMotor.setPower(Range.clip(0,-1.0,1.0));
            backRightMotor.setPower(Range.clip(0,-1.0,1.0));
        }

        void goBackward (double power) {
            // func of making robot go backwards
            frontLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            backLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            frontRightMotor.setPower(Range.clip(0,-1.0,1.0));
            backRightMotor.setPower(Range.clip(0,-1.0,1.0));
        }

        void turnLeft (double power) {
            // func of making robot go left
            frontRightMotor.setPower(Range.clip(0,-1.0,1.0));
            backRightMotor.setPower(Range.clip(0,-1.0,1.0));
            frontLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            backLeftMotor.setPower(Range.clip(0,-1.0,1.0));
        }

        void turnRight (double power) {
            // func of making robot go right
            frontLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            backLeftMotor.setPower(Range.clip(0,-1.0,1.0));
            frontRightMotor.setPower(Range.clip(0,-1.0,1.0));
            backRightMotor.setPower(Range.clip(0,-1.0,1.0));
        }

        void strafeRight (double power) {
            // func of making robot strafe left **still questionable
            frontLeftMotor.setPower(-1.0);
            backLeftMotor.setPower(1.0);
            frontRightMotor.setPower(1.0);
            backRightMotor.setPower(-1.0);

        }

        void strafeLeft (double power) {
        //func of making robot strafe right **still questionable*********
            frontLeftMotor.setPower(1.0);
            backLeftMotor.setPower(-1.0);
            frontRightMotor.setPower(-1.0);
            backRightMotor.setPower(1.0);
        }

}
