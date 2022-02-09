//<<<<<<< HEAD
//package org.firstinspires.ftc.teamcode;
//
//public class AutonMethods {
//    public static void MoveForward(int inches){
//        Hardware3.BLMotor.setPower();
//    }
//}

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
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

//28 ticks in a rotation
public class AutonMethods{
    /*public int ticksToRotation(int ticks){

        return ticks /= 28;
    }

     */

    private Hardware2 robot;

    public void turnCarousel(int seconds) {
        robot.carouselDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.carouselDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double startTime = robot.runtime.seconds();

        while ((robot.runtime.seconds() - startTime) < seconds) {
            //figure out which way reverse or not reverse to turn the carousel, only needs one rotation in the right direction
            robot.carouselDrive.setVelocity(.75);
        }

    }

//    public void moveForward(Hardware2 robot, int ticks) {
//        int startPos = robot.flDrive.getCurrentPosition();
//        while ((robot.flDrive.getCurrentPosition() - startPos) < ticks) {
//            robot.flDrive.setVelocity(.2);
//            robot.frDrive.setVelocity(.2);
//            robot.blDrive.setVelocity(.2);
//            robot.brDrive.setVelocity(.2);
//        }
//    }
    public void moveForward(int ticks) {
        int startPos = robot.flDrive.getCurrentPosition();
        while ((robot.flDrive.getCurrentPosition() - startPos) < ticks) {
            robot.flDrive.setVelocity(.2);
            robot.frDrive.setVelocity(.2);
            robot.blDrive.setVelocity(.2);
            robot.brDrive.setVelocity(.2);
        }
    }

    public void moveBackward(int ticks) {

    }
}
//public class AutonMethods {
   // public static void MoveForward(int inches){
       // Hardware2.blDrive.setPower(

       // Hardware2.blDrive.setVelocity(

