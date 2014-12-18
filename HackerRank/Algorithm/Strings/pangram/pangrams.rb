#!/usr/bin/ruby


def pangram? (string)
    hash = Hash.new
    string.downcase.gsub(/\W/,'').split('').each { |s|
        unless hash.has_key?(s)
            hash[s] = 1
        end

        if hash.keys.size() == 26
            return true;
        end
    }
    return false;
end

puts pangram?(gets.chomp) ? "pangram" : "not pangram"
