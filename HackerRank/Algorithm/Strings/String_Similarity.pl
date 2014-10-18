#!/usr/bin/perl
use strict;
use warnings;

# Head ends here

sub stringSimilarity
{
    my ($string1) = @_;
    
    my $count = 0;
    foreach (1..(length $string1))
    {
    	my $string2 = substr $string1, ((-1)*$_);
    	$count += stringCmp($string1,$string2);
    }
    return $count;
}


sub stringCmp
{
	my ($str1,$str2) = @_;

	if(length $str2 >0)
	{
		if ($str1 eq $str2)
		{
			return length $str1;
		}
		else
		{
			return stringCount($str1,$str2);
		}
	}
	else
	{
		return 0;
	}
	
}


sub stringCount
{
	my ($str1,$str2) = @_;

	my $count = 0;
	if((substr $str1,0,1) eq (substr $str2,0,1))
	{
		$count++;
		$count += stringCmp((substr $str1,1),(substr $str2,1));
	}
	return $count;
}




#Tail starts here
my $test_cases = <>;
for (my $index = 0; $index < $test_cases; $index++)
{
    my $input = <>;
    chomp $input;
    print stringSimilarity($input);
    print "\n";  
}

# print stringSimilarity('ababaa')."\n";
# print Dumper \%countHash;