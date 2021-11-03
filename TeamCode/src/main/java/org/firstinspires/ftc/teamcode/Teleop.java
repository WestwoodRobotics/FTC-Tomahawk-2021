package org.firstinspires.ftc.robotcontroller.external.samples;

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

    private DcMotor FLDrive = null;
    private DcMotor FRDrive = null;
    private DcMotor BLDrive = null;
    private DcMotor BRDrive = null;

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

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        //lol
        FLDrive.setDirection(DcMotor.Direction.FORWARD);
        FRDrive.setDirection(DcMotor.Direction.FORWARD);
        BLDrive.setDirection(DcMotor.Direction.FORWARD);
        BRDrive.setDirection(DcMotor.Direction.FORWARD);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
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
        // Setup a variable for each drive wheel to save power level for telemetry
        double FLPower;
        double FRPower;
        double BLPower;
        double BRPower;

        //Power adjusting
        FLPower = -gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
        FRPower = -gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
        BLPower = -gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
        BRPower = -gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;

        double max = findMax(FLPower, FRPower, BLPower, BRPower);
        if (max != 0) {
            FLPower /= max;
            FRPower /= max;
            BLPower /= max;
            BRPower /= max;
        }

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

        FLDrive.setPower(FLPower);
        FRDrive.setPower(FRPower);
        BLDrive.setPower(BLPower);
        BRDrive.setPower(BRPower);


        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
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
