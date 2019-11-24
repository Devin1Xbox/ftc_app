package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous(name = "RepositionSkystones", group = "LinearOpMode")
public class RepositionSkystones extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        int red = 0;

        waitForStart();
        oDistanceSensor.enableLed(true);
        while(opModeIsActive()) {
            telemetry.addData("currentBlueValue", colorSensor.blue());
            telemetry.addData("currentRedValue", colorSensor.red());
            telemetry.addData("currentGreenValue", colorSensor.green());
            telemetry.addData("currentDistance", oDistanceSensor.getLightDetected());
            telemetry.update();

            red = colorSensor.red();

            goForward(.25);
            if(red > 150) {
                this.stopMotors();
                stop();
            }


        }


//        telemetry.addData("frontLeft Position", frontLeftMotor.getCurrentPosition());
//        telemetry.addData("backLeft position", backLeftMotor.getCurrentPosition());
//        telemetry.addData("frontRight position", frontRightMotor.getCurrentPosition());
//        telemetry.addData("backRight position", backRightMotor.getCurrentPosition());
//        telemetry.update();
//        add code


    }
}
