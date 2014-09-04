//
//  CardMatchingGame.m
//  DemoMatchismo
//

#import "CardMatchingGame.h"

@interface CardMatchingGame()
@property (nonatomic,readwrite)NSInteger score;
@property(nonatomic,strong)NSMutableArray *cards; // of Cards
@end

@implementation CardMatchingGame


-(NSMutableArray *) cards
{
    if (!_cards) _cards=[[NSMutableArray alloc] init];
    return _cards;
}

- (instancetype) initWithCardCount:(NSUInteger)count usignDeck:(Deck *)deck
{
    self=[super init];
    if (self){
        
        for (int i=0;i<count;i++){
            Card *card = [deck drawRandomCard];
            if(card){
                [self.cards[i] addObject:card];
            } else{
                self=nil;
                break;
            }
            
        }
        
    }
    return self;
}


- (Card *)cardAtIndex:(NSUInteger)index
{
    return (index <[self.cards count]) ? self.cards[index] : nil;
}

static const int MISMATCH_PENALTY=2;
static const int MATCH_BONUS=4;

-(void) chooseCardAtIndex:(NSUInteger)index
{
    Card *card = [self cardAtIndex:index];
    
    if(!card.isMatched){
        if (card.isChosen){
            card.choosen=NO;
        } else {
            //match again another card
            for (Card *otherCard in self.cards){
                if (otherCard.isChosen && !otherCard.isMatched){
                    int matchScore = [card match:@[otherCard]];
                    if (matchScore){
                        self.score+=matchScore*MATCH_BONUS;
                        card.matched=YES;
                        otherCard.matched=YES;
                        
                    }else{
                        self.score-=MISMATCH_PENALTY;
                        otherCard.choosen=NO;
                        
                    }
                }
                
            }
        }
    }
}



@end
