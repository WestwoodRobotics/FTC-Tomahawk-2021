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
public class Teleop extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor flDrive = null;
    private DcMotor frDrive = null;
    private DcMotor blDrive = null;
    private DcMotor brDrive = null;
    private DcMotor linearSlideDrive = null;
    private DcMotor intakeDrive = null;
    private DcMotor carouselDrive = null;
    private DcMotor fourth = null;
    private DcMotor fifth = null;
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        flDrive = hardwareMap.get(DcMotor.class, "front_left_drive");
        frDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        blDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        brDrive = hardwareMap.get(DcMotor.class, "back_right_drive");
        linearSlideDrive = hardwareMap.get(DcMotor.class, "extra_motor_1");
        intakeDrive = hardwareMap.get(DcMotor.class, "extra_motor_2");
        carouselDrive = hardwareMap.get(DcMotor.class, "extra_motor_3");
        fourth = hardwareMap.get(DcMotor.class, "extra_motor_4");
        fifth = hardwareMap.get(DcMotor.class, "extra_motor_5");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        //setting direction
        flDrive.setDirection(DcMotor.Direction.FORWARD);
        frDrive.setDirection(DcMotor.Direction.REVERSE);
        blDrive.setDirection(DcMotor.Direction.FORWARD);
        brDrive.setDirection(DcMotor.Direction.REVERSE);
        linearSlideDrive.setDirection(DcMotor.Direction.FORWARD);
        intakeDrive.setDirection(DcMotor.Direction.FORWARD);
        carouselDrive.setDirection(DcMotor.Direction.FORWARD);
        fourth.setDirection(DcMotor.Direction.FORWARD);
        fifth.setDirection(DcMotor.Direction.FORWARD);

        //setting zero power behavior to brake instead of float.
        //brake means that moving the wheel is met with active resistance
        flDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        blDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlideDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        carouselDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fourth.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //float means the wheel will be able to be pushed

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
        if(gamepad2.y){
            linearSlidePower = 1;
        }
        if(gamepad2.a){
            linearSlidePower = -1;
        }
        if(gamepad2.x){
            intakePower = 1;
        }
        if(gamepad2.b){
            intakePower = -1;
        }
        if(gamepad2.dpad_up){
            carouselPower = 1;
        }
        if(gamepad2.dpad_down){
            carouselPower = -1;
        }
        if(gamepad2.dpad_left){
            fourthPower = 1;
        }
        if(gamepad2.dpad_right){
            fourthPower = -1;
        }

        flDrive.setPower(flPower);
        frDrive.setPower(frPower);
        blDrive.setPower(blPower);
        brDrive.setPower(brPower);
        linearSlideDrive.setPower(linearSlidePower);
        intakeDrive.setPower(intakePower);
        carouselDrive.setPower(carouselPower);
        fourth.setPower(fourthPower);


        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        flDrive.setPower(0);
        frDrive.setPower(0);
        blDrive.setPower(0);
        brDrive.setPower(0);
        linearSlideDrive.setPower(0);
        intakeDrive.setPower(0);
        carouselDrive.setPower(0);
        fourth.setPower(0);

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
