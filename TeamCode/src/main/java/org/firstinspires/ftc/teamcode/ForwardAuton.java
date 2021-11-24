package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Forward Auton", group="Linear Opmode")
//@Disabled
public class BasicOpMode_Linear extends LinearOpMode {
  private ElapsedTime runtime = new ElapsedTime();
  //private DcMotor leftDrive = null;
  //private DcMotor rightDrive = null;

  DcMotor FLDrive;
  DcMotor FRDrive;
  DcMotor BLDrive;
  DcMotor BRDrive;

  double power = 0.5;

  @Override
  public void runOpMode() {
    telemetry.addData("Status", "Initialized");
    telemetry.update();

    FLDrive  = hardwareMap.get(DcMotor.class, "front_left_drive");
    FRDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
    BLDrive  = hardwareMap.get(DcMotor.class, "back_left_drive");
    BRDrive = hardwareMap.get(DcMotor.class, "back_right_drive");

    FLDrive.setDirection(DcMotor.Direction.FORWARD);
    FRDrive.setDirection(DcMotor.Direction.FORWARD);
    BLDrive.setDirection(DcMotor.Direction.REVERSE);
    BRDrive.setDirection(DcMotor.Direction.REVERSE);

    waitForStart();
    runtime.reset();

    FLDrive.setPower(power);
    FRDrive.setPower(power);
    BLDrive.setPower(power);
    BRDrive.setPower(power);

    sleep(2000);
    power = 0.0;

    FLDrive.setPower(power);
    FRDrive.setPower(power);
    BLDrive.setPower(power);
    BRDrive.setPower(power);

    /*
    while (opModeIsActive()) {
      double leftPower;
      double rightPower;
      double drive = -gamepad1.left_stick_y;
      double turn  =  gamepad1.right_stick_x;
      leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
      rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

      leftDrive.setPower(leftPower);
      rightDrive.setPower(rightPower);

      telemetry.addData("Status", "Run Time: " + runtime.toString());
      telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
      telemetry.update();
    }
    */
  }
}
