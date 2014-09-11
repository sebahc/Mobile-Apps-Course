//
//  CardGameViewController.m
//  DemoMatchismo
//


#import "CardGameViewController.h"
#import "PlayingCardDeck.h"
#import "CardMatchingGame.h"

@interface CardGameViewController ()

@property(nonatomic,strong) CardMatchingGame *game;
@property (strong, nonatomic) IBOutletCollection(UIButton) NSArray *cardButtons;
@property (weak, nonatomic) IBOutlet UILabel *scoreLabel;

@end

@implementation CardGameViewController

- (CardMatchingGame *)game
{
    if(!_game) _game=[[CardMatchingGame alloc] initWithCardCount:[self.cardButtons count ]
                                                       usignDeck:[[PlayingCardDeck alloc] init]];
    return _game;
}


/*-(Deck *)createDeck
{
    return [[PlayingCardDeck alloc] init];
}*/


- (IBAction)touchCardButton:(UIButton *)sender
{
    int cardIndex = [self.cardButtons indexOfObject:sender];
    //NSLog(@"index %d", cardIndex);
    [self.game chooseCardAtIndex:cardIndex];
    [self updateUI];
}

-(void) updateUI
{
    for (UIButton *cardButton in self.cardButtons){
        int cardIndex = [self.cardButtons indexOfObject:cardButton];
        Card *card = [self.game cardAtIndex:cardIndex];
        [cardButton setTitle:[self titleForCard:card]
                    forState:UIControlStateNormal];
        [cardButton setBackgroundImage:[self BackgroundImageForCard:card]
                              forState:UIControlStateNormal];
        cardButton.enabled=!card.isMatched;
        self.scoreLabel.text=[NSString stringWithFormat:@"Score: %d",self.game.score];
        
    }
    
    
}

-(NSString *)titleForCard:(Card *) card
{
    return card.isChosen ? card.contents : @"";
}

-(UIImage *)BackgroundImageForCard:(Card *) card
{
    return [UIImage imageNamed:card.isChosen ? @"cardfront" : @"cardback"];
}



@end
