package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public abstract class Robot extends LinearOpMode  {

    private DcMotor motor;

    // this is the constructor
    // you instantiate motors and hardware here
    // hardware.getMotor or whatever



    DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, armMotor;

        @Override
        public void runOpMode () {
            System.out.println("This is the hardware map from ROOBT" + hardwareMap);
            frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
            backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
            frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
            backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
            armMotor = hardwareMap.get(DcMotor.class, "armMotor");

            frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
            backRightMotor.setDirection(DcMotor.Direction.REVERSE);
        }

        void goForward (double power){
            // func of making robot go forwards
            telemetry.addData("frontLeftMotor", power);
            telemetry.addData("backLeftMotor", power);
            telemetry.addData("frontRightMotor", power);
            telemetry.addData("backRightMotor", power);
            telemetry.addData("armMotor", power);
            telemetry.update();

            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void goBackward (double power) {
            // func of making robot go backwards
            telemetry.addData("frontLeftMotor", power);
            telemetry.addData("backLeftMotor", power);
            telemetry.addData("frontRightMotor", power);
            telemetry.addData("backRightMotor", power);
            telemetry.update();

            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void turnLeft (double power) {
            telemetry.addData("frontLeftMotor", power);
            telemetry.addData("backLeftMotor", power);
            telemetry.addData("frontRightMotor", power);
            telemetry.addData("backRightMotor", power);
            telemetry.update();

            // func of making robot go left
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);


        }

        void turnRight (double power) {
            telemetry.addData("frontLeftMotor", -power);
            telemetry.addData("backLeftMotor", -power);
            telemetry.addData("frontRightMotor", power);
            telemetry.addData("backRightMotor", power);
            telemetry.update();

            // func of making robot go right
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void strafeRight (double power) {
            telemetry.addData("frontLeftMotor", -power);
            telemetry.addData("backLeftMotor", power);
            telemetry.addData("frontRightMotor", power);
            telemetry.addData("backRightMotor", -power);
            telemetry.update();

            // func of making robot strafe left **still questionable
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(-power);

        }

        void strafeLeft (double power) {
            telemetry.addData("frontLeftMotor", power);
            telemetry.addData("backLeftMotor", -power);
            telemetry.addData("frontRightMotor", -power);
            telemetry.addData("backRightMotor", power);
            telemetry.update();

        //func of making robot strafe right **still questionable*********
            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(-power);
            backRightMotor.setPower(power);
        }
//
        void arm (double power) {
            telemetry.addData("armMotor", power);
            telemetry.update();
            armMotor.setPower(power);
        }

}
