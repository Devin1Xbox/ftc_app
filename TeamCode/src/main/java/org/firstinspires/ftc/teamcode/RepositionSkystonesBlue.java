package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RepositionSkystonesBlue", group = "LinearOpMode")
public class RepositionSkystonesBlue extends Robot {


    @Override
    public void runOpMode() {
        super.runOpMode();

        waitForStart();
        while(opModeIsActive()) {
            int red = colorSensor.red();
            int blue = colorSensor.blue();
            int green = colorSensor.green();
            telemetry.addData("currentBlueValue", blue);
            telemetry.addData("currentRedValue", red);
            telemetry.addData("currentGreenValue", green);
            telemetry.update();

            this.armMotor.setPower(1.0);
            this.whileLoopWait(1000);
            this.openArm();
            ElapsedTime time = new ElapsedTime();
            runtime.reset();
            while (this.opModeIsActive() && time.milliseconds() < 1000) {
                this.armMotor.setPower(0);
                this.armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            }

            goForwardsInInches(23.2);
            strafeLeftInInches(23.5);
            turnRightInMilli(32);
            goForwardsInInches(1);
            Log.i("REPOSITION-CLASS", "red: " + this.red);
            strafeRightUntilDetectSkystone();
            this.stopMotors();
//            runtime.reset();
            this.strafeRightInInches(0.87);
            goForwardsInInches(7);
            closeArm();
            goBackwardsInInches(38);
            strafeLeftInInches(60);
            openArm();
            goForwardsInInches(5);
            goBackwardsInInches(7);
            strafeRightInInches(9);
            stop();
        }
    }
}