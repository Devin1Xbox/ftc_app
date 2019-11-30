package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RepositionFoundationBlue", group = "LinearOpMode")
public class RepositionFoundationBlue extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        waitForStart();

        telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
        telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
        telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
        telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
        telemetry.update();
        //all operations already have sleeps for two seconds except for the ones that are used in main
        this.openArm();
        this.sleep(2000);
        this.armMotor.setPower(0.8);
        this.sleep(2000);
        this.goForwardsInInches(26);
        this.resetArm();
        this.sleep(2000);
        this.goBackwardsInInches(29.5);
        this.strafeRightInInches(35.25);
    }
}
