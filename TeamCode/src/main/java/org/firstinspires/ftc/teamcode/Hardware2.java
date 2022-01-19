package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.*;


public class Hardware2 {
    public DcMotor flDrive = null;
    public DcMotor frDrive = null;
    public DcMotor blDrive = null;
    public DcMotor brDrive = null;
    public DcMotor linearSlideDrive = null;
    public DcMotor intakeDrive = null;
    public DcMotor carouselDrive = null;
    public DcMotor fourth = null;
    public DcMotor fifth = null;
    public HardwareMap hardwareMap;
    public ElapsedTime runtime = new ElapsedTime();
    public Hardware2(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
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

    }


    }


