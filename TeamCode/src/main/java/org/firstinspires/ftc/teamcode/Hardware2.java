package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap
import java.util.*;


public class Hardware2{
        static DcMotor flDrive = null;
        static DcMotor frDrive = null;
        static DcMotor blDrive = null;
        static DcMotor brDrive = null;
        static DcMotor linearSlideDrive = null;
        static DcMotor intakeDrive = null;
        static DcMotor carouselDrive = null;
        static DcMotor fourth = null;
        static DcMotor fifth = null;
        static HardwareMap hardwareMap;
        public Hardware2(HardwareMap hardwareMap){
                this.hardwareMap = hardwareMap;
        }

        public void assignHardware(){
                this.flDrive = this.hardwareMap.get(DcMotor.class, "front_left_drive");
                this.frDrive = this.hardwareMap.get(DcMotor.class, "front_right_drive");
                this.blDrive = this.hardwareMap.get(DcMotor.class, "back_left_drive");
                this.brDrive = this.hardwareMap.get(DcMotor.class, "back_right_drive");
                this.linearSlideDrive = this.hardwareMap.get(DcMotor.class, "extra_motor_1");
                this.intakeDrive = this.hardwareMap.get(DcMotor.class, "extra_motor_2");
                this.carouselDrive = this.hardwareMap.get(DcMotor.class, "extra_motor_3");
                this.fourth = this.hardwareMap.get(DcMotor.class, "extra_motor_4");
                this.fifth = this.hardwareMap.get(DcMotor.class, "extra_motor_5");


                flDrive.setDirection(DcMotor.Direction.FORWARD);
                frDrive.setDirection(DcMotor.Direction.REVERSE);
                blDrive.setDirection(DcMotor.Direction.FORWARD);
                brDrive.setDirection(DcMotor.Direction.REVERSE);
                intakeDrive.setDirection(DcMotor.Direction.FORWARD);
                carouselDrive.setDirection(DcMotor.Direction.FORWARD);
                flDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                frDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                blDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                brDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                intakeDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                carouselDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        }
        }
