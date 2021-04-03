package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class AutoEpicTime extends LinearOpMode{

    DcMotor frontLeft, frontRight, backLeft, backRight, tread, fire;
    double power = 0.5;
    double power2 = 1.0;
    double tor;
    private boolean shouldShoot = true;
    private boolean shouldDrive = false;
    private boolean shouldDetectRings = true;
    private boolean ringDetectTestMode = false;
//    private ElapsedTime runtime = new ElapsedTime();
//    HardwarePushbot robot = new HardwarePushbot();
    public void runOpMode(){
//        robot.init(hardwareMap);
        frontLeft = hardwareMap.dcMotor.get("Front Left");
        frontRight = hardwareMap.dcMotor.get("Front Right");
        backLeft = hardwareMap.dcMotor.get("Back Left");
        backRight = hardwareMap.dcMotor.get("Back Right");
        tread = hardwareMap.dcMotor.get("Tread");
        fire = hardwareMap.dcMotor.get("Fire");
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        waitForStart();

//        if(opModeIsActive()){
//            do {
//              switch (){
//                  case 0:
//
//                      break;
//
//                  case 1:
//
//                      break;
//
//                  case 2:
//
//                      break;
//              }
//            }while(opModeIsActive() && ringDetectTestMode){
//                if(ringDetectTestMode){
//                    while(opModeIsActive()){
//                        telemetry.update();
//                    }
//                }
//            }
//
//        }
        if(opModeIsActive()){
       //     move();
            fire.setPower(.5);
            pull(0.7);
            fire(.85);
        }

    }

    public void pull(double tor){
        tread.setPower(-tor);
        sleep(2000);
        tread.setPower(0);
    }
    public void fire(double tor){
        fire.setPower(tor);
        sleep(2000);
    //    if(time < 20){
            fire.setPower(0);
    //    }
    }
    public void move(){
                frontLeft.setPower(-power);

                frontRight.setPower(power);
                backLeft.setPower(-power);
                backRight.setPower(power);
                sleep( 4000);
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
    }
}
