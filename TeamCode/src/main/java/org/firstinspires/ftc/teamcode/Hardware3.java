package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    static DcMotor FLMotor;
    static DcMotor FRMotor;
    static DcMotor BLMotor;
    static DcMotor BRMotor;
    static DcMotor CarouselMotor;
    static HardwareMap hardwareMap;

    public Hardware(HardwareMap hardwaremap) {
        hardwareMap = hardwaremap;
    }
    public static void HardwareInit() {
        FLMotor = hardwareMap.get(DcMotor.class, "front_left_drive");
        FRMotor = hardwareMap.get(DcMotor.class, "front_right_drive");
        BLMotor = hardwareMap.get(DcMotor.class, "front_right_drive");
        BRMotor = hardwareMap.get(DcMotor.class, "front_right_drive");
        CarouselMotor = hardwareMap.get(DcMotor.class, "carousel_drive");

        FLMotor.setDirection(DcMotor.Direction.FORWARD);
        FRMotor.setDirection(DcMotor.Direction.REVERSE);
        BLMotor.setDirection(DcMotor.Direction.FORWARD);
        BRMotor.setDirection(DcMotor.Direction.REVERSE);
        CarouselMotor.setDirection(DcMotor.Direction.FORWARD);
    }
}
