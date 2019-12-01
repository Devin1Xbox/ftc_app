package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous(name = "RepositionSkystonesRed", group = "LinearOpMode")
public class RepositionSkystonesRed extends Robot {


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

            openArm();

            red = colorSensor.red();

//            goForward(.25);
//            if(red > 150) {
//                this.stopMotors();
//                closeArm();
//                goBackwardsInInches(47);
//            }
            goForwardsInInches(25);
            strafeRightInInches(13);//maybe?
            strafeLeft(0.25);
            if(red < 20) {
                this.stopMotors();
                strafeLeftInInches(3.33);
                goForwardsInInches(3.5);
                closeArm();
                goBackwardsInInches(47);
                strafeRightInInches(52);
                openArm();
                goForwardsInInches(4);
                goBackwardsInInches(5);
                strafeLeftInInches(52);
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
