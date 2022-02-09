package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.*;


@TeleOp(name="Tomahawk")
public class Teleop extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor FLDrive = null;
    private DcMotor FRDrive = null;
    private DcMotor BLDrive = null;
    private DcMotor BRDrive = null;
    private DcMotor carouselDrive = null;
    private DcMotor slideDrive = null;

//    private Servo intake = null;
//    private Servo intakeArm = null;


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
        carouselDrive = hardwareMap.get(DcMotor.class, "carousel_drive");
        slideDrive = hardwareMap.get(DcMotor.class, "slide_drive");

//        intake = hardwareMap.get(Servo.class, "intake_servo");
//        intakeArm = hardwareMap.get(Servo.class, "intake_arm_servo");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        //lol XD
        FLDrive.setDirection(DcMotor.Direction.FORWARD);
        FRDrive.setDirection(DcMotor.Direction.REVERSE);
        BLDrive.setDirection(DcMotor.Direction.FORWARD);
        BRDrive.setDirection(DcMotor.Direction.REVERSE);
        carouselDrive.setDirection(DcMotor.Direction.FORWARD);
        slideDrive.setDirection(DcMotor.Direction.FORWARD);
        slideDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        intake.setDirection(Servo.Direction.FORWARD);
//        intakeArm.setDirection(Servo.Direction.FORWARD);

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

        double carouselPower = 0.5;
        double slidePower = 0.0;
        double intakePower = 0.0;
        double intakeArmPower = 0.0;

        //Old Power adjusting
//        FLPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
//        FRPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;
//        BLPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
//        BRPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;

        //Power adjusting
        FLPower = (gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
        FRPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;
        BLPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / 2;
        BRPower = (gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / 2;



        if (gamepad1.x && gamepad1.b) {
            carouselPower = 0.0;
        } else if (!gamepad1.x && !gamepad1.b) {
            carouselPower = 0.0;
        } else if (gamepad1.x && !gamepad1.b) {
            carouselPower = 1.0;
        } else if (!gamepad1.x && gamepad1.b) {
            carouselPower = -1.0;
        }

        if (gamepad1.y){
            slidePower = 1.0;
        } else if (gamepad1.a){
            slidePower = -1.0;
        } else {
            slidePower = 0;
        }

        //Servo powers
        if (gamepad1.dpad_up) {
            intakeArmPower = 1;
        } else if (gamepad1.dpad_down){
            intakeArmPower = 0;
        }else{
            intakeArmPower = 0.5;
        }

        if(gamepad1.dpad_right){
            intakePower = 1;

        }else if (gamepad1.dpad_left){
            intakePower = 0;
        }else{
            intakePower = 0.5;
        }


        /*if (gamepad1.y && gamepad1.a) {
            slidePower = 0.0;
        } else if (!gamepad1.y && !gamepad1.a) {
            slidePower = 0.0;
        } else if (gamepad1.y && !gamepad1.a) {
            slidePower = 1.0;
        } else if (!gamepad1.y && gamepad1.a) {
            slidePower = -1.0;
        }
*/
        //else if (gamepad2.y) {
//            slidePower = 1;
//        } else if (gamepad2.a) {
//            slidePower = -1;
//        }

        double max = findMax(FLPower, FRPower, BLPower, BRPower);

        if (max != 0) {
            FLPower /=max;
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

        FLDrive.setPower(FLPower * 0.65);
        FRDrive.setPower(FRPower * 0.65);
        BLDrive.setPower(BLPower * 0.65);
        BRDrive.setPower(BRPower * 0.65);



        carouselDrive.setPower(carouselPower);
        slideDrive.setPower(slidePower*.5);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "carousel (%.2f)", carouselPower);

//        intake.setPosition(0.5);
    }

    /*1
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
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