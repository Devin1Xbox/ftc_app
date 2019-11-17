package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TestAutonomousMovement", group = "LinearOpMode")
public class TestAutonomousMovement extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        waitForStart();

        telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
        telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
        telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
        telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
        telemetry.update();

        this.goForwardsInInches(10);
        this.goBackwardsIncches(5);

    }
}