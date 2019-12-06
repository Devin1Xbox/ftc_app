package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "RepositionFoundationRed", group = "LinearOpMode")
public class RepositionFoundationRed extends Robot {


        @Override
        public void runOpMode() {
                super.runOpMode();

                waitForStart();
                armMotor.setDirection(DcMotor.Direction.REVERSE);
                telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
                telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
                telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
                telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
                telemetry.update();
                this.armMotor.setPower(1.0);
                this.whileLoopWait(500);
                this.openArm();
                this.goForwardsInInches(32.6);
                this.strafeRightInInches(4);
                this.resetArm();
                whileLoopWait(1000);
//        ElapsedTime time = new ElapsedTime();
//        time.reset();
//        while (this.opModeIsActive() && time.milliseconds() < 1000) {
//            this.armMotor.setPower(0);
//            this.armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        }
                this.closeArm();
                this.whileLoopWait(375);
                this.openArm();
                this.whileLoopWait(375);
                this.goBackwardsInInches(45);
                this.armMotor.setPower(0.78);
                this.whileLoopWait(500);
                this.strafeLeftInInches(38);
                this.resetArm();
                this.turnRightInMilli(100);
                this.closeArm();
                this.goForwardsInInches(56);
                this.strafeRightInInches(27);
                this.goBackwardsInInches(50);
                this.strafeLeftInInches(57);
                this.closeArm();
                stop();
        }
}