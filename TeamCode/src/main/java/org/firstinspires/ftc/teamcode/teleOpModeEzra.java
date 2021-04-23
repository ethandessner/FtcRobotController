package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

@TeleOp
public class teleOpModeEzra extends OpMode {

    DcMotor frontLeft, frontRight, backLeft, backRight, tread, fire;
    VoltageSensor vs = hardwareMap.voltageSensor.get("name of usb motor controller");
    double voltage = vs.getVoltage();


    double power = 1.0;
    boolean toggle = true;
    int tap = 0;
    //    boolean start = false;
    double power2 = 1.0;
    double powerFire = 0.0;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("Front Left");
        frontRight = hardwareMap.dcMotor.get("Front Right");
        backLeft = hardwareMap.dcMotor.get("Back Left");
        backRight = hardwareMap.dcMotor.get("Back Right");
        tread = hardwareMap.dcMotor.get("Tread");
        fire = hardwareMap.dcMotor.get("Fire"); // fly wheel
//        start = true;
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

            /*
            frontLeft.setPower(gamepad1.left_stick_y * power);
            frontRight.setPower(gamepad1.right_stick_y * -power);
            backLeft.setPower(gamepad1.left_stick_y * power);
            backRight.setPower(gamepad1.right_stick_y * -power);
*/
        frontLeft.setPower(gamepad1.left_stick_y * power);
        frontRight.setPower(gamepad1.right_stick_y * -power);
        backLeft.setPower(gamepad1.left_stick_y * power);
        backRight.setPower(gamepad1.right_stick_y * -power);
        fire.setPower(0);
        tread.setPower(0);

        if (gamepad2.right_bumper) {
            fire.setPower(powerFire);
        }

        if(gamepad2.left_bumper){
            fire.setPower(-powerFire);
        }

        if (gamepad2.y) {
            tread.setPower(-power2);
        }

        if(gamepad2.a){
            tread.setPower(power2);
        }

        if (gamepad1.left_bumper) {

            frontLeft.setPower(-power);
            frontRight.setPower(-power);
            backLeft.setPower(power);
            backRight.setPower(power);

        }

        if (gamepad1.right_bumper) {

            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(-power);
            backRight.setPower(-power);

        }

        if (gamepad1.dpad_up) {


            frontLeft.setPower(power);
            frontRight.setPower(-power);
            backLeft.setPower(power);
            backRight.setPower(-power);

        }

        if (gamepad1.dpad_down) {

            frontLeft.setPower(-power);
            frontRight.setPower(power);
            backLeft.setPower(-power);
            backRight.setPower(power);

        }

//            if (gamepad1.b && tap == 0) {
//                power = power/2;
//                tap = 1;
//            }
//            if (gamepad1.b && tap == 1) {
//                power = power * 2;
//                tap = 0;
//            }
        if (gamepad2.b) {
            power2 = 0.7;
        }
        if (gamepad2.x) {
            power2 = 0.5;
        }
        if (gamepad1.b) {
            power = 0.7;
        }
        if (gamepad1.a) {
            power = 1.0;
        }
        if(gamepad2.dpad_up){
            powerFire = 1.0;
        }
        if(gamepad2.dpad_right) {
            powerFire = 0.85;
        }
        if(gamepad2.dpad_left){
            powerFire = 0.75;
        }
        if(gamepad2.dpad_down){
            powerFire = 0.8;
        }


//        while(start && toggle) {
//            if (gamepad1.a) {
//                tap++;
//                power /= 2;
//            }
//            if(gamepad1.b){
//                toggle = true;
//            }
//            while (tap == 1) {
//                power /= 2;
//                tap = 0;
//            }
//            if (gamepad1.a && tap == 0) {
//                power *= 2;
//                tap = 0;
//            }
//            toggle = false;
//        }

        telemetry.addData("Voltage: ", vs.getVoltage() );
        telemetry.addData("Current Toggle Value for Ethan: ", power);
        telemetry.addData("Current Toggle Value for Alicia: ", power2);
        telemetry.addData("Current Toggle Value for Fire Power: ", powerFire);

    }
}
