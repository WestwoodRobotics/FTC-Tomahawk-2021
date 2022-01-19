package org.firstinspires.ftc.teamcode;
<<<<<<< HEAD
=======

import static java.lang.Math.abs;
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
<<<<<<< HEAD
import com.qualcomm.robotcore.hardware.DcMotorSimple;
=======
import com.qualcomm.robotcore.hardware.DcMotorEx;
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.*;

<<<<<<< HEAD

@TeleOp(name="Tomahawk")
public class Teleop extends OpMode
{
=======
@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")

public class Teleop extends OpMode {
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware2 robot;
    Boolean isRunning = false;
    Boolean isoff = true;

<<<<<<< HEAD
    private DcMotor FLDrive = null;
    private DcMotor FRDrive = null;
    private DcMotor BLDrive = null;
    private DcMotor BRDrive = null;
    private DcMotor XBDrive = null;
    private DcMotor YADrive = null;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        FLDrive = hardwareMap.get(DcMotor.class, "front_left_drive");
        FRDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        BLDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        BRDrive = hardwareMap.get(DcMotor.class, "back_right_drive");
        XBDrive = hardwareMap.get(DcMotor.class, "x_button_drive");
        YADrive = hardwareMap.get(DcMotor.class, "b_button_drive");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        //lol XD
        FLDrive.setDirection(DcMotor.Direction.FORWARD);
        FRDrive.setDirection(DcMotor.Direction.REVERSE);
        BLDrive.setDirection(DcMotor.Direction.FORWARD);
        BRDrive.setDirection(DcMotor.Direction.REVERSE);
        XBDrive.setDirection(DcMotor.Direction.FORWARD);
        YADrive.setDirection(DcMotor.Direction.FORWARD);
=======
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot = new Hardware2(hardwareMap);
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1

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
<<<<<<< HEAD
        // Setup a variable for each drive wheel to save power level for telemetry
        double FLPower;
        double FRPower;
        double BLPower;
        double BRPower;

        double XBPower = 0.5;
        double YAPower = 0.5;

        //Power adjusting
        FLPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
        FRPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;
        BLPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
        BRPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;



        if (gamepad1.x && gamepad1.b) {
            XBPower = 0;
        } else if (!gamepad1.x && !gamepad1.b) {
            XBPower = 0;
        } else if (gamepad1.x && !gamepad1.b) {
            XBPower = 1;
        } else if (!gamepad1.x && gamepad1.b) {
            XBPower = -1;
        }

        //else if (gamepad2.y) {
//            YAPower = 1;
//        } else if (gamepad2.a) {
//            YAPower = -1;
//        }

        double max = findMax(FLPower, FRPower, BLPower, BRPower);

        if (max != 0) {
            FLPower /=max;
            FRPower /= max;
            BLPower /= max;
            BRPower /= max;
=======
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
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1
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


<<<<<<< HEAD


        //FL
//        if ((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) > 1) {
//            double max = findMax(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
//            FLPower = (-gamepad1.left_stick_y / max) + (gamepad1.left_stick_x / max) + (gamepad1.right_stick_x / max);
//        } else {
//            FLPower = -gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
//        }
//        //FR
//        if ((-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) > 1) {
//            double max = findMax(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);
//            FRPower = (-gamepad1.left_stick_y / max) - (gamepad1.left_stick_x / max) - (gamepad1.right_stick_x / max);
//        } else {
//            FRPower = -gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
//        }
//        //BL
//        if ((-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) > 1) {
//            double max = findMax(-gamepad1.left_stick_y, -gamepad1.left_stick_x, gamepad1.right_stick_x);
//            BLPower = ((-gamepad1.left_stick_y / max) - (gamepad1.left_stick_x / max) + (gamepad1.right_stick_x / max));
//        } else {
//            BLPower = -gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
//        }
//        //BR
//        if ((-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) > 1) {
//            double max = findMax(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x);
//            BRPower = ((-gamepad1.left_stick_y / max) + (gamepad1.left_stick_x / max) - (gamepad1.right_stick_x / max));
//        } else {
//            BRPower = -gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;
//        }

        FLDrive.setPower(FLPower * 0.65);
        FRDrive.setPower(FRPower * 0.65);
        BLDrive.setPower(BLPower * 0.65);
        BRDrive.setPower(BRPower * 0.65);
=======
        robot.flDrive.setPower(flPower);
        robot.frDrive.setPower(frPower);
        robot.blDrive.setPower(blPower);
        robot.brDrive.setPower(brPower);
        robot.linearSlideDrive.setPower(linearSlidePower);
        robot.intakeDrive.setPower(intakePower);
        robot.carouselDrive.setPower(carouselPower);
        robot.fourth.setPower(fourthPower);
>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1

        XBDrive.setPower(XBPower * 0.75);
        YADrive.setPower(YAPower * 0.75);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
<<<<<<< HEAD
        telemetry.addData("Motors", "carousel (%.2f)", XBPower);
=======

>>>>>>> 1bbde928885c8c7f3e3113f49b11f4e82974a4e1
    }

    /*1
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
        double[] nums = {Math.abs(num1), Math.abs(num2), Math.abs(num3), Math.abs(num4)};

        double max = -0.1;
        for (double num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


}