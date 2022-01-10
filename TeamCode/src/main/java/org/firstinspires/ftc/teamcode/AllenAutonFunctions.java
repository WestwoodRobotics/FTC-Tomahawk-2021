package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class AllenAutonFunctions {
    static final int TICKSPERINCH = 360;
    static final int TICKSPERCAROUSELINCH = 999;

    public AllenAutonFunctions() {
        ;
    }

    public static void forward(int inches) {
        Hardware3.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hardware3.FLMotor.setTargetPosition(inches * TICKSPERINCH);
        Hardware3.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setPowers(1,1,1,1,0);
        while (Hardware3.FLMotor.isBusy()) {
            ;
        }
        setPowers(0,0,0,0,0);
    }
    public static void backward(int inches) {
        Hardware3.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware3.FLMotor.setTargetPosition(inches * TICKSPERINCH);
        Hardware3.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setPowers(-1,-1,-1,-1,0);
        while (Hardware3.FLMotor.isBusy()) {
            ;
        }
        setPowers(0,0,0,0,0);
    }
    public static void left(int inches) {
        Hardware3.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware3.FLMotor.setTargetPosition(inches * TICKSPERINCH);
        Hardware3.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setPowers(-1,1,1,-1,0);
        while (Hardware3.FLMotor.isBusy()) {
            ;
        }
        setPowers(0,0,0,0,0);
    }
    public static void right(int inches) {
        Hardware3.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware3.FLMotor.setTargetPosition(inches * TICKSPERINCH);
        Hardware3.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setPowers(1,-1,-1,1,0);
        while (Hardware3.FLMotor.isBusy()) {
            ;
        }
        setPowers(0,0,0,0,0);
    }
    public static void carousel(int inches) {
        Hardware3.CarouselMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hardware3.CarouselMotor.setTargetPosition(inches * TICKSPERINCH);
        Hardware3.CarouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setPowers(0,0,0,0,1);
        while (Hardware3.CarouselMotor.isBusy()) {
            ;
        }
        setPowers(0,0,0,0,0);
    }
    public static void setPowers(int FLDrive, int FRDrive, int BLDrive, int BRDrive, int CarouselDrive) {
        Hardware3.FLMotor.setPower(FLDrive);
        Hardware3.FRMotor.setPower(FRDrive);
        Hardware3.BLMotor.setPower(BLDrive);
        Hardware3.BRMotor.setPower(BRDrive);
        Hardware3.CarouselMotor.setPower(CarouselDrive);
    }
}
