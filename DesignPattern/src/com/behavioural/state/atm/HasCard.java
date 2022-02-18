package com.behavioural.state.atm;

public class HasCard implements ATMState {

	ATMMachine atmMachine;

	public HasCard(ATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}

	@Override
	public void insertCard() {
		System.out.println("Already card is inserted");
	}

	@Override
	public void ejectCard() {
		System.out.println("Card is ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
	}

	@Override
	public void insertPin(int pinEntered) {
		if(1234==pinEntered) {
			System.out.println("Correct pin is entered");
			atmMachine.setATMState(atmMachine.getHasPin());
		}else {
			System.out.println("Wrong pin is entered");
		}
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		if(atmMachine.cashInMachine>=cashToWithdraw) {
			System.out.println("Correct pin is entered");
			atmMachine.cashInMachine = atmMachine.cashInMachine - cashToWithdraw;
		}else {
			System.out.println("Insufficient fund");
		}
		
		if(atmMachine.cashInMachine <= 0) {
			atmMachine.setATMState(atmMachine.getNoCashState());
		}
	}

}
