package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RepositionFoundationBlue", group = "LinearOpMode")
public class RepositionFoundationBlue extends Robot {


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
        this.whileLoopWait(1000);
        this.openArm();
        this.goForwardsInInches(32.6);
        this.strafeLeftInInches(4);
        this.resetArm();
        ElapsedTime time = new ElapsedTime();
        time.reset();
        while (this.opModeIsActive() && time.milliseconds() < 1000) {
            this.armMotor.setPower(0);
            this.armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
        this.closeArm();
        this.whileLoopWait(500);
        this.openArm();
        this.whileLoopWait(500);
        this.goBackwardsInInches(40);
        time.reset();
        while (opModeIsActive() && time.milliseconds() < 500) {
            this.armMotor.setPower(0.78);
        }
        this.strafeRightInInches(25);
        this.armMotor.setPower(0);
        this.armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.strafeRightInInches(25);
    }
}