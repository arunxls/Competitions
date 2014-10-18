#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;
# Head ends here

sub stringSimilarity
{
    my (@string) = split('',$_[0]);

    my $seed = $string[0];
    my $count = scalar @string;
    
    foreach my $index (1..$#string)
    {
    	if ($string[0] ne $string[$index])
    	{
    		next;
    	}
    	else
    	{
    		foreach (0..$#string-$index)
			{
				if($string[$_+$index] eq $string[$_])
				{
					$count++;
				}
				else
				{
					last;
				}
			}
    	}
    }
    return $count;
}


#Tail starts here
# my $test_cases = <>;
# for (my $index = 0; $index < $test_cases; $index++)
# {
#     my $input = <>;
#     chomp $input;
#     print stringSimilarity($input);
#     print "\n";  
# }

print stringSimilarity('ababab')."\n";
