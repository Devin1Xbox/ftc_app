package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

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
        ElapsedTime time = new ElapsedTime();
        time.reset();
        this.armMotor.setPower(1.0);
        while(time.milliseconds() < 2000) {
            // do nothing; wait for two seconds for the arm to fully raise
        }
        this.goForwardsInInches(26);
        this.strafeLeftInInches(4);
        this.armMotor.setPower(1.0);
        time.reset();
        this.armMotor.setPower(1.0);
        while(time.milliseconds() < 2000) {
            // do nothing; wait for two seconds for the arm to fully raise and have power going to it
        }
        this.resetArm();
        this.sleep(2000);
        this.closeArm();
        this.sleep(500);
        this.openArm();
        this.sleep(500);
        this.goBackwardsInInches(29.5);
        this.strafeRightInInches(35.25);
    }
}