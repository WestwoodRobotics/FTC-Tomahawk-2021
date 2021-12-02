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

public class AutonMethods{

    public void turnCarousel(Hardware2 robot, int ticks) {
        robot.carouselDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.carouselDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (robot.carouselDrive.getCurrentPosition() < ticks) {

            //figure out which way reverse or not reverse to turn the carousel, only needs one rotation in the right direction
            robot.carouselDrive.setPower(1);
        }

    }

    public void moveForward(Hardware2 robot, int ticks) {
        robot.flDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.blDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.brDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.flDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.blDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.brDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (robot.flDrive.getCurrentPosition() < ticks) {
            robot.flDrive.setPower(.5);
            robot.frDrive.setPower(-.5);
            robot.blDrive.setPower(.5);
            robot.brDrive.setPower(-.5);
        }
    }
}
//public class AutonMethods {
   // public static void MoveForward(int inches){
       // Hardware2.blDrive.setPower(