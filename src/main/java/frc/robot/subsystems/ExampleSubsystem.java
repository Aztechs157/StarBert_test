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
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ExampleCommand;
import frc.robot.controllers.ControllerSet;

public class ExampleSubsystem extends SubsystemBase {
    /**
     * Creates a new ExampleSubsystem.
     */
    public final DigitalOutput out0;
    public final DigitalInput in1;
    public final CANSparkMax motor1;

    public ExampleSubsystem(final ControllerSet controller) {
        this.motor1 = new CANSparkMax(0, MotorType.kBrushless);
        this.out0 = new DigitalOutput(0);
        this.in1 = new DigitalInput(1);
        setDefaultCommand(new ExampleCommand(this, controller));
    }

    /**
     * sets the speed of a motor to a desired value between 1 and -1
     *
     * @param speed the value between 1 and -1 to set the motor to. if it is out of
     *              that range, it will bound the value to that range
     */
    public void run(double speed) {
        motor1.set(speed);
    }

    @Override
    public void periodic() {

        // This method will be called once per scheduler run
    }
}
