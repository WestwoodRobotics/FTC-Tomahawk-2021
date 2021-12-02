package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.*;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
@Disabled
public class Teleop extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware2 robot;
    Boolean isRunning = false;
    Boolean isoff = true;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot = new Hardware2(hardwareMap);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }


    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double flPower = 0;
        double frPower = 0;
        double blPower = 0;
        double brPower = 0;
        double linearSlidePower = 0;
        double intakePower = 0;
        double carouselPower = 0;
        double fourthPower = 0;

        flPower = -gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
        flPower = -gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
        blPower = -gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
        brPower = -gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;

        double max = findMax(flPower, frPower, blPower, brPower);
        if (max != 0) {
            flPower /= max;
            frPower /= max;
            blPower /= max;
            brPower /= max;
        }
        //(y, a) (x,a)
        //y is for linear slide up
        if (gamepad2.y) {
            linearSlidePower = 1;
        }
        if (gamepad2.a) {
            linearSlidePower = -1;
        }
        if (gamepad2.x) {
            intakePower = 1;
        }
        if (gamepad2.b) {
            intakePower = -1;
        }
        if (gamepad2.dpad_up) {
            carouselPower = 1;
        }
        if (gamepad2.dpad_down) {
            carouselPower = -1;
        }
        if (gamepad2.dpad_left) {
            fourthPower = 1;
        }
        if (gamepad2.dpad_right) {
            fourthPower = -1;
        }
        if (gamepad2.a && !isRunning) {
            intakePower = 1;
            isRunning = true;
        } else if (isRunning && !gamepad2.dpad_up) {
            isoff = true;
        }
        if (gamepad2.a && !isoff) {
            isoff = true;
            isRunning = false;
            intakePower = 0;
        }


        robot.flDrive.setPower(flPower);
        robot.frDrive.setPower(frPower);
        robot.blDrive.setPower(blPower);
        robot.brDrive.setPower(brPower);
        robot.linearSlideDrive.setPower(linearSlidePower);
        robot.intakeDrive.setPower(intakePower);
        robot.carouselDrive.setPower(carouselPower);
        robot.fourth.setPower(fourthPower);


        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        robot.flDrive.setPower(0);
        robot.frDrive.setPower(0);
        robot.blDrive.setPower(0);
        robot.brDrive.setPower(0);
        robot.linearSlideDrive.setPower(0);
        robot.intakeDrive.setPower(0);
        robot.carouselDrive.setPower(0);
        robot.fourth.setPower(0);

    }

    public double findMax(double num1, double num2, double num3, double num4) {
        double[] nums = {abs(num1), abs(num2), abs(num3), abs(num4)};

        double max = -0.1;
        for (double num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


}