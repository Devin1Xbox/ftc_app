package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RepositionSkystonesRed", group = "LinearOpMode")
public class RepositionSkystonesRed extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        int red = 0;

        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("currentBlueValue", colorSensor.blue());
            telemetry.addData("currentRedValue", colorSensor.red());
            telemetry.addData("currentGreenValue", colorSensor.green());
            telemetry.update();

            openArm();

            red = colorSensor.red();

//            goForward(.25);
//            if(red > 150) {
//                this.stopMotors();
//                closeArm();
//                goBackwardsInInches(47);
//            }
            goForwardsInInches(22.3);
//            while(red >)//maybe?
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
    }
}