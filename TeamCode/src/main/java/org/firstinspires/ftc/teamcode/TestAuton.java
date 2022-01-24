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
public class TestAuton extends LinearOpMode {
    //declare Opmode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware2 robot;
    //private AutonMethods autonMethods = new AutonMethods();
    private AllenAutonFunctions allenMethods = new AllenAutonFunctions();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initiallized");
        telemetry.update();
        robot = new Hardware2(hardwareMap);
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            //blue upper quad
            allenMethods.forward(24);
            allenMethods.turnRight(180);
            allenMethods.left(73);
            allenMethods.forward(18);
            allenMethods.carousel(24);
            allenMethods.backward(18);



            //blue lower quad
            /*allenMethods.forward(24);
            allenMethods.turnRight(180);
            allenMethods.left(24);
            allenMethods.forward(18);
            allenMethods.carousel(24);
            allenMethods.backward(18);*/

            //red upper quad
            /*allenMethods.forward(24);
            allenMethods.turnRight(180);
            allenMethods.right(73);
            allenMethods.forward(18);
            allenMethods.carousel(24);
            allenMethods.backward(18);*/


            //red lower quad
            /*allenMethods.forward(24);
            allenMethods.turnRight(180);
            allenMethods.right(24);
            allenMethods.forward(18);
            allenMethods.carousel(24);
            allenMethods.backward(18);*/
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();

    }
}

