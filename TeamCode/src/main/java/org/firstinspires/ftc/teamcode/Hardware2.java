package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.*;


public class Hardware2 {
    public DcMotorEx flDrive = null;
    public DcMotorEx frDrive = null;
    public DcMotorEx blDrive = null;
    public DcMotorEx brDrive = null;
    public DcMotorEx linearSlideDrive = null;
    public DcMotorEx intakeDrive = null;
    public DcMotorEx carouselDrive = null;
    public DcMotorEx fourth = null;
    public DcMotorEx fifth = null;
    public HardwareMap hardwareMap;
    public ElapsedTime runtime = new ElapsedTime();
    public Hardware2(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        flDrive = hardwareMap.get(DcMotorEx.class, "front_left_drive");
        frDrive = hardwareMap.get(DcMotorEx.class, "front_right_drive");
        blDrive = hardwareMap.get(DcMotorEx.class, "back_left_drive");
        brDrive = hardwareMap.get(DcMotorEx.class, "back_right_drive");
        linearSlideDrive = hardwareMap.get(DcMotorEx.class, "extra_motor_1");
        intakeDrive = hardwareMap.get(DcMotorEx.class, "extra_motor_2");
        carouselDrive = hardwareMap.get(DcMotorEx.class, "extra_motor_3");
        fourth = hardwareMap.get(DcMotorEx.class, "extra_motor_4");
        fifth = hardwareMap.get(DcMotorEx.class, "extra_motor_5");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        //setting direction
        flDrive.setDirection(DcMotorEx.Direction.FORWARD);
        frDrive.setDirection(DcMotorEx.Direction.REVERSE);
        blDrive.setDirection(DcMotorEx.Direction.FORWARD);
        brDrive.setDirection(DcMotorEx.Direction.REVERSE);
        linearSlideDrive.setDirection(DcMotorEx.Direction.FORWARD);
        intakeDrive.setDirection(DcMotorEx.Direction.FORWARD);
        carouselDrive.setDirection(DcMotorEx.Direction.FORWARD);
        fourth.setDirection(DcMotorEx.Direction.FORWARD);
        fifth.setDirection(DcMotorEx.Direction.FORWARD);

        //setting zero power behavior to brake instead of float.
        //brake means that moving the wheel is met with active resistance
        flDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        blDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        linearSlideDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        intakeDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        carouselDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        fourth.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        //float means the wheel will be able to be pushed

    }


    }


