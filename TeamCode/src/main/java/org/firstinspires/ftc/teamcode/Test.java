/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode ;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Robot;
import java.lang.annotation.Target;



/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Josiah-Test", group="Linear Opmode")
public class Test extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor = null;


    // Go backward x distance
    public int goDistance(int distance, double power) {
        int position = motor.getCurrentPosition();
        telemetry.addData("Initial Position ", position);
        //set target to input
        int TargetPosition;
        if (power < 0) {
            TargetPosition = position - distance;
        } else {
            TargetPosition = position + distance;
        }
        motor.setTargetPosition(distance);
        motor.setPower(power);
        return TargetPosition;
    }

    //Update Telemetry
    public void updateTelemetry() {
        int position = motor.getCurrentPosition();
        telemetry.addData("Current Position ", position);
        telemetry.update();
    }

    // Determine if stop button has been pressed
    public boolean stopButtonPressed() {
        final boolean isStopRequested1 = true;
        if (isStopRequested1 == true) {
            Thread.currentThread().stop();

        }
        return (isStopRequested());
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

//        Robot lol = new Robot();
//
//        lol.frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
//        lol.backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
//        lol.frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
//        lol.backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
//
//        lol.frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
//        lol.backRightMotor.setDirection(DcMotor.Direction.REVERSE);
//
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//        runtime.reset();

//        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        while (opModeIsActive()) {


//            this.sleep(1000);
//            lol.strafeRight(1.0);
//            goDistance(10000, 1.0);
//
//            while(position <= 9995) {
////                if(stopButtonPressed()) {
////                    requestOpModeStop();
////                }
//                updateTelemetry();                 DIDNT WORK
//            }
//
//            goDistance(-10000, -1.0);
//
//            while(position >= 0) {
////                if(stopButtonPressed()) {
////                    requestOpModeStop();
////                }
//                updateTelemetry();
//            }
//        }
//    }
        }
    }
}