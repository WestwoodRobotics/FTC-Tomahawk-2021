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

public class AutonMethods() {

    public void turnCarousel(int ticks) {
        Hardware2.carouselDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware2.carouselDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (Hardware2.carouselDrive.getCurrentPosition() < ticks) {

            //figure out which way reverse or not reverse to turn the carousel, only needs one rotation in the right direction
            Hardware2.carouselDrive.setPower(1);
        }

    }
    public void moveForward(int ticks) {
        flDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        blDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        brDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        flDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        blDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (flDrive.getCurrentPosition() < ticks) {
            flDrive.setPower(.5);
            frDrive.setPower(-.5);
            blDrive.setPower(.5);
            brDrive.setPower(-.5);
        }
}
//public class AutonMethods {
   // public static void MoveForward(int inches){
       // Hardware2.blDrive.setPower(