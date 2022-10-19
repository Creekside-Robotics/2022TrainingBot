// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  
  WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.DriveTrainConstants.leftFrontCANID);
  WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.DriveTrainConstants.leftBackCANID);
  WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.DriveTrainConstants.rightFrontCANID);
  WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.DriveTrainConstants.rightBackCANID);

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);


  // /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    leftControllerGroup.setInverted(true);
    rightControllerGroup.setInverted(false);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDrive(double fowardSpeed, double turnRate){
    this.differentialDrive.arcadeDrive(fowardSpeed, turnRate);
  }


}
