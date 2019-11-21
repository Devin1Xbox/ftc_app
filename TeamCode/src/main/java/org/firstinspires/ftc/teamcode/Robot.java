package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public abstract class Robot extends LinearOpMode  {




    ElapsedTime runtime = new ElapsedTime();

    Servo armServo, armServo1;

    DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, armMotor;

        @Override
        public void runOpMode () {
            System.out.println("This is the hardware map from ROOBT" + hardwareMap);
            frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
            backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
            frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
            backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");
            armMotor = hardwareMap.get(DcMotor.class, "armMotor");
            armServo = hardwareMap.get(ServoImpl.class, "armServo");
            armServo1 = hardwareMap.get(ServoImpl.class, "armServo1");


            frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
            backRightMotor.setDirection(DcMotor.Direction.REVERSE);
        }


        void goForward ( double power){
            // func of making robot go forwards

            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void goBackward ( double power){
            // func of making robot go backwards

            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void turnLeft (double power) {

            // func of making robot go left
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);


        }

        void turnRight (double power) {
            // func of making robot go right
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(power);
        }

        void strafeRight (double power) {

            // func of making robot strafe left **still questionable
            frontLeftMotor.setPower(-power);
            backLeftMotor.setPower(power);
            frontRightMotor.setPower(power);
            backRightMotor.setPower(-power);

        }

        void strafeLeft (double power) {

        //func of making robot strafe right **still questionable*********
            frontLeftMotor.setPower(power);
            backLeftMotor.setPower(-power);
            frontRightMotor.setPower(-power);
            backRightMotor.setPower(power);
        }

        void stopMotors () {
            this.frontLeftMotor.setPower(0);
            this.backLeftMotor.setPower(0);
            this.frontRightMotor.setPower(0);
            this.backRightMotor.setPower(0);
        }

        void arm (double power) {
            telemetry.addData("armMotor", power);
            telemetry.update();
            armMotor.setPower(power);
        }

        void raiseArmHalf () {
            armMotor.setPower(-0.65);
            this.sleep(1000);
        }

        void resetArm() {
            armMotor.setPower(0);
            armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            telemetry.addData("armMotor", armMotor.getPower());
            telemetry.update();
        }

        void openArm() {
            this.sleep(176);
            armServo.setPosition(1);
            armServo1.setPosition(0);
        }

        void closeArm() {

            armServo.setPosition(0);
            this.sleep(176);
            armServo1.setPosition(1);
        }

        void goForwardsInInches(double inches) {
            // we need to do some trail runs to find the real calculation
            double calculatedTime = inches * 36.73469388;
            this.runtime.reset();

            while(this.runtime.milliseconds() < calculatedTime && opModeIsActive()) {
                this.goForward(-0.75);
            }
            this.stopMotors();
            this.sleep(2000);
        }

        void goBackwardsInInches(double inches) {
            // we need to do some trail runs to find the real calculation
            double calculatedTime = inches * 36.73469388;
            this.runtime.reset();

            while(this.runtime.milliseconds() < calculatedTime) {
                this.goBackward(0.75);
            }
            this.stopMotors();
            this.sleep(2000);
        }

        void turnLeftInFeet(double feet) {
            // we need to do some trail runs to find the real calculation
            double calculatedTime = feet;
            this.runtime.reset();

            while(this.runtime.milliseconds() < calculatedTime) {
                this.turnLeft(-0.75);
            }
            this.stopMotors();
        }

        void encodedGoForwards(int position, double power) {

            int timeout = 2;

            this.runtime.reset();
            this.stopAndResetEncoder();
            this.setRunUsingEncoder();

            frontLeftMotor.setTargetPosition(-position);
            backLeftMotor.setTargetPosition(position);
            frontRightMotor.setTargetPosition(position);
            backRightMotor.setTargetPosition(-position);



            this.setRunToPosition();

            goForward(power);



            while(
                    opModeIsActive()
                    && (Math.abs(this.frontLeftMotor.getCurrentPosition()) < position)
            ) {
                int positionFL = this.frontLeftMotor.getCurrentPosition();
                int positionBL = this.backLeftMotor.getCurrentPosition();
                int positionFR = this.frontRightMotor.getCurrentPosition();
                int positionBR = this.backRightMotor.getCurrentPosition();

                System.out.println("OMG is this even working:::::::" + positionFL);
                telemetry.addData("frontLeft Position", positionFL);
                telemetry.addData("backLeft position", positionBL);
                telemetry.addData("frontRight position", positionFR);
                telemetry.addData("backRight position", positionBR);
                telemetry.update();

            }
        }

        void stopAndResetEncoder() {
            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        void setRunToPosition() {
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        void setRunUsingEncoder() {
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

}
