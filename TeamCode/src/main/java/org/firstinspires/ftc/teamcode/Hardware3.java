package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware3 {
    static DcMotorEx FLMotor;
    static DcMotorEx FRMotor;
    static DcMotorEx BLMotor;
    static DcMotorEx BRMotor;
    static DcMotorEx CarouselMotor;
    static HardwareMap hardwareMap;

    public Hardware3(HardwareMap hardwaremap) {
        hardwareMap = hardwaremap;
    }
    public static void HardwareInit() {
        FLMotor = hardwareMap.get(DcMotorEx.class, "front_left_drive");
        FRMotor = hardwareMap.get(DcMotorEx.class, "front_right_drive");
        BLMotor = hardwareMap.get(DcMotorEx.class, "front_right_drive");
        BRMotor = hardwareMap.get(DcMotorEx.class, "front_right_drive");
        CarouselMotor = hardwareMap.get(DcMotorEx.class, "carousel_drive");

        FLMotor.setDirection(DcMotorEx.Direction.FORWARD);
        FRMotor.setDirection(DcMotorEx.Direction.REVERSE);
        BLMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BRMotor.setDirection(DcMotorEx.Direction.REVERSE);
        CarouselMotor.setDirection(DcMotorEx.Direction.FORWARD);

        FLMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        FRMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        BLMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        BRMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        CarouselMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        FLMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FRMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        CarouselMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


    }
}
