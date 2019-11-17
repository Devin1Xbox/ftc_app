package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RepositionFoundation", group = "LinearOpMode")
public class RepositionFoundation extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        waitForStart();

        telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
        telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
        telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
        telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
        telemetry.update();

        this.openArm();
        this.sleep(500);
        this.armMotor.setPower(0.8);
        this.goForwardsInInches(26);
        this.sleep(1000);
        this.resetArm();
        this.sleep(2000);
        this.goBackwardsIncches(29.5);

    }
}