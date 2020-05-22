/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ExampleCommand;

public class ExampleSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public DigitalOutput out0;
  public DigitalInput in1;
  public Encoder enc23;
  public TalonSRX motor1;

  public ExampleSubsystem() {
    motor1 = new TalonSRX(0);
    out0 = new DigitalOutput(0);
    in1 = new DigitalInput(1);
    enc23 = new Encoder(2, 3, false, EncodingType.k4X);
    setDefaultCommand(new ExampleCommand(this));
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
