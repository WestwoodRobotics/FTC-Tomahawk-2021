package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;
//disabled
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.*;
//teleOp
@Autonomous(name = "Redside carousel",
group="linear Opmode")
//@Disabled
public class TestAuton2 extends LinearOpMode {
    //declare Opmode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware2 robot;
    private AutonMethods autonMethods = new AutonMethods();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initiallized");
        telemetry.update();
        robot = new Hardware2(hardwareMap);
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            if(runtime.seconds() < 4) {
                autonMethods.moveForward(100);
            }
            if (runtime.seconds() > 8) {
                autonMethods.turnCarousel(9);
            }
        }
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

        }
    }

