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
            while(opModeIsActive()) {
                telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
                telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
                telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
                telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
                telemetry.update();
                this.armMotor.setPower(1.0);
                this.whileLoopWait(1000);
                this.openArm();
                this.goForwardsInInches(30.5);
                this.strafeLeftInInches(4);
                this.resetArm();
                this.whileLoopWait(2000);
                this.closeArm();
                this.whileLoopWait(750);
                this.openArm();
                this.whileLoopWait(750);
                this.goBackwardsInInches(28);
                this.strafeRightInInches(35.25);
            }
    }
}