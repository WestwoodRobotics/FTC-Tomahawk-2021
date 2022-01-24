package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RedCarousel",
        group="linear Opmode")

public class RedCarousel extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware3 robot;

    private AllenAutonFunctions allenMethods = new AllenAutonFunctions();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot = new Hardware3(hardwareMap);
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            allenMethods.forward(24);
            allenMethods.turnRight(180);
            allenMethods.right(24);
            allenMethods.forward(18);
            allenMethods.carousel(24);
            allenMethods.backward(18);
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();

    }
}


