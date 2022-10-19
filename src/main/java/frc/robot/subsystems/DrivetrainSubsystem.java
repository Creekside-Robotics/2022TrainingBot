// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {

  Encoder leftEncoder = new Encoder(Constants.DriveTrainConstants.leftFrontCANID, Constants.DriveTrainConstants.leftBackCANID);
  Encoder rightEncoder = new Encoder(Constants.DriveTrainConstants.rightFrontCANID, Constants.DriveTrainConstants.rightBackCANID);
  
  TalonSRX leftFrontMotor = new TalonSRX(Constants.DriveTrainConstants.leftFrontCANID);
  TalonSRX leftBackMotor = new TalonSRX(Constants.DriveTrainConstants.leftBackCANID);
  TalonSRX rightFrontMotor = new TalonSRX(Constants.DriveTrainConstants.rightFrontCANID);
  TalonSRX rightBackMotor = new TalonSRX(Constants.DriveTrainConstants.rightBackCANID);

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);


  // /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {

    leftFrontMotor.configFactoryDefault();
    leftBackMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    rightBackMotor.configFactoryDefault();

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightControllerGroup.setInverted(true);
    rightControllerGroup.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
