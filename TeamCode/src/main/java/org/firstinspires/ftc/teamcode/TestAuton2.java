package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap
import java.util.*;

@TeleOp(name = "Basic: Linear Opmode",
group="linear Opmode")
@Disabled
public class TestAuton2 extends LinearOpMode {
    //declare Opmode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware2 robot;

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initiallized");
        telemetry.update();
        robot = new Hardware2(hardwareMap);
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            moveForward(200);
            if(runtime.seconds() > 7){
                turnCarousel(100);
            }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

        }
    }
}
